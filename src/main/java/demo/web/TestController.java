package demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndex() {
        return "hello world";
    }

}
