package pers.luchuan.test.controller;

import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pers.luchuan.test.annotation.Statistics;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created By Lu Chuan On 2019/3/9
 */
@RestController
@RequestMapping("/validate")
@Validated
//@PropertySource("classpath:message.properties")
public class TestValidationController {
	
	@PostMapping("/field")
	public void testValid(@NotNull(message = "{name.null}") String name) {
		System.out.println(name);
	}
	
	@Statistics
	@GetMapping("/method5")
	public String method5(){
		return "method5方法执行了";
	}
}
