package com.main.exercise.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author Alberto
 * 
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/ci")
public class ExerciseController {
	
	/**
	 * Método que mapea headers.
	 * @param request HttpServletRequest objecto con headers definidos y predefinidos
	 * @return Map<String, List<String>> un mapa de los headers con su respetiva lista de posibles valores múltiples
	 */
	@GetMapping("/getHeaders")
	public Map<String, List<String>> getHeaders(HttpServletRequest request) {	
		Map<String, List<String>> map = new Hashtable<String, List<String>>();

		Stream<String> headerNames = (Stream<String>)
				Collections.list(request.getHeaderNames())
				.stream();
		headerNames.forEach(element ->{
			List<String> list = new ArrayList<>();
			String[] array = request.getHeader(element).split(",");
			List<String> resultArray = Arrays.asList(array);
			resultArray.forEach(x->{
				list.add(x);	
			});

			map.put(element, list);
		});

		return map;
	}
	/**
	 * Método que filtra headers respecto de los parámetros enviados.
	 * @param request HttpServletRequest objecto con headers definidos y predefinidos
	 * @param headerNames List<String> Lista de Strings
	 * @return Map<String, List<String>> un mapa de los headers con su respetiva lista de posibles valores múltiples filtrados
	 */
	@GetMapping("/filteredHeaders")
	public Map<String, List<String>> filteredHeaders(HttpServletRequest request, @RequestBody List<String> headerNames) {
		Map<String, List<String>> map = new Hashtable<String, List<String>>();
		
		headerNames.forEach(element ->{			
			List<String> list = new ArrayList<>();
			String[] array = request.getHeader(element).split(",");
			List<String> resultArray = Arrays.asList(array);
			resultArray.forEach(x->{
				list.add(x);	
			});
			map.put(element, list);
		}); 
	

		return map;
	}
}
