/**
 * 
 */
package co.edureka.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author root
 *
 */

@Controller
@RestController
public class ApplicationController {

	@RequestMapping("/default")
	public ModelAndView retrieveLoginPage() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("default");
		return mav;
	}
}
