package com.abbas.springchallengetwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class SpringChallengeTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringChallengeTwoApplication
                .class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Please choose a doctor:" +
                "<br>" +
                "<a href='/doctor/1'>Doctor 1</a>"
                + "<br>" +
                "<a href='/doctor/9?name=Christopher%20Eccleston'>Doctor 9</a>"
                + "<br>" +
                "<a href='/doctor/10?name=David%20Tennant'>Doctor 10</a>"
                + "<br>" +
                "<a href='/doctor/11?name=Matt%20Smith'>Doctor 11</a>"
                + "<br>" +
                "<a href='/doctor/12?name=Peter%20Capaldi'>Doctor 12</a>"
                + "<br>" +
                "<a href='/doctor/13?name=Jodie%20Whittaker'>Doctor 13</a>";

    }

    @RequestMapping("/doctor/{id}")
    @ResponseBody
    public String doctor(@PathVariable int id, @RequestParam(required = false) String name) throws ResponseStatusException {

        switch (id) {
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return String.format("{'number': %s,'name': '%s'}", id, name);
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                throw new ResponseStatusException(HttpStatus.SEE_OTHER);
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible to retrieve the incarnation " + id);

        }
    }

}

