package com.example.demo.helpers;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class ListConverterHelper {

 private static final Logger logger = LoggerFactory.getLogger(ListConverterHelper.class);

 @Value("${process.forced}")
 private String proccesForzed;

 @Value("${process.parallel.elements.more}")
 private int THRESHOLD_SIZE;

 @Value("${process.parallel.cores.more}")
 private int CORES_SIZE;

 public <S, T> List<T> convertList(List<S> source, Class<T> targetClass, ConversionService conversionService) {
     // Decide based on the size of the list and number of available processors
     if (source == null) {
         return Collections.emptyList();
     }
     if (shouldUseParallel(source.size())) {
         return convertListParallel(source, targetClass, conversionService);
     } else {
         return convertListSequential(source, targetClass, conversionService);
     }
 }

 private <S, T> List<T> convertListSequential(List<S> source, Class<T> targetClass,
         ConversionService conversionService) {
     logger.info("Method [convertList Secuential] source.size: " + source.size());
     return source.stream().filter(Objects::nonNull) // Filtra elementos nulos
             .map(element -> conversionService.convert(element, targetClass)).collect(Collectors.toList());
 }

 private <S, T> List<T> convertListParallel(List<S> source, Class<T> targetClass,
         ConversionService conversionService) {
     logger.info("Method [convertList Secuential] source.size: " + source.size());
     return source.parallelStream().filter(Objects::nonNull) // Filtra elementos nulos
             .map(element -> conversionService.convert(element, targetClass)).collect(Collectors.toList());
 }

 private boolean shouldUseParallel(int size) {
     // Consider using parallel processing if the list size is larger than the
     // threshold
     // and the machine has more than one processor.
     if (this.proccesForzed.equals("parallel"))
         return true;
     if (this.proccesForzed.equals("secuential"))
         return false;
     return size >= THRESHOLD_SIZE && Runtime.getRuntime().availableProcessors() >= CORES_SIZE;
 }
}
