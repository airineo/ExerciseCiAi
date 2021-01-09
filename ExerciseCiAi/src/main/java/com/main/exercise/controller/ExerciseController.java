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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	 * @param request HttpServletRequest objecto
	 * @return 
	 */
	@GetMapping("/getHeaders")
	public Map<String, List<String>> getHeaders(HttpServletRequest request) {	
		Map<String, List<String>> map = new Hashtable<String, List<String>>();

		Stream<String> headerNames = (Stream<String>)
				Collections.list(request.getHeaderNames())
				.stream();
		headerNames.forEach(element ->{
			List<String> list = new ArrayList<>();
			list.add(request.getHeader(element));
			map.put(element, list);
		});

		return map;
	}
	/**
	 * Método que filtra headers respecto de los parámetros enviados.
	 * @param request HttpServletRequest Objecto
	 * @param headerNames List<String> Lista de Strings
	 * @return Map<String, List<String>> Devuelve un mapa de los elementos filtrados en base a headersNames
	 */
	@GetMapping("/filteredHeaders")
	public Map<String, List<String>> filteredHeaders(HttpServletRequest request, @RequestParam("headerNames") List<String> headerNames) {
		Map<String, List<String>> map = new Hashtable<String, List<String>>();
		Stream<String> headerNames1 = (Stream<String>)
				Collections.list(request.getHeaderNames())
				.stream();
		
		headerNames.forEach(element ->{
			headerNames1.filter(header -> header == element);
			List<String> list = new ArrayList<>();
			list.add(request.getHeader(element));
			map.put(element, list);
		});


		return map;
	}
}
