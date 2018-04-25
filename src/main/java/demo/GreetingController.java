package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GreetingController {
	
	@Autowired
	SessionRepository redisRepository;

	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	@RequestMapping("/greeting")
	public String greeting(Model model, HttpServletRequest request) {

		String id = (String)request.getSession().getId();
		Session session = redisRepository.findOne(id);
		
		logger.info("Session Id is: " + id);

		if (session == null)
			return "login";
		else {
			model.addAttribute("name", session.getName());
			return "greeting";
		}
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.POST)
	public String whoareyou(@RequestParam(value = "name", required = true) String name, Model model,
			HttpServletResponse response, HttpServletRequest request) {

		logger.info("Remembering " + name);
		redisRepository.save(new Session((String)request.getSession().getId(), name, 30L));

		model.addAttribute("name", name);
		return "greeting";
	}

}
