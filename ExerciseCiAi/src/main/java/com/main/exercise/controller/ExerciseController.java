package com.main.exercise.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	 * @param request HttpServletRequest objecto
	 * @return 
	 */
	@GetMapping("/getHeaders")
	public Map<String, List<String>> getHeaders(HttpServletRequest request) {
		System.out.println("HEADER NAMES : ");
		System.out.println(request.getHeaderNames());
		System.out.println("HEADERs prueba : ");
		System.out.println(request.getHeaders("prueba"));
		Map<String, List<String>> map = new Hashtable<String, List<String>>();
		List<String> list = new ArrayList<>();
		list.add("hola");
		list.add("alberto");
		map.put("prueba", list);
		
		return map;
	}
	/**
	 * Método que filtra headers respecto de los parámetros enviados.
	 * @param request HttpServletRequest Objecto
	 * @param headerNames List<String> Lista de Strings
	 * @return Map<String, List<String>> Devuelve un mapa de los elementos filtrados en base a headersNames
	 */
	@GetMapping("/filteredHeaders")
	public Map<String, List<String>> filteredHeaders(HttpServletRequest request, List<String> headerNames) {
		return null;
	}
}
