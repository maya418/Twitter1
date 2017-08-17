package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
   @Autowired
   MessageRepository messageRepository;

   @RequestMapping("/")
   public String Index(Model model)
   {
       model.addAttribute("message" , messageRepository.findAll());
       return "index";
   }
   @RequestMapping("/message")
    public String newMessage(Model model)
   {
       model.addAttribute("message" , new Message());
       return "messageform";
   }

   @RequestMapping("/process")
    public String processForm(@ModelAttribute Message message)
   {
      messageRepository.save(message);
      return "redirect:/";
   }
}
