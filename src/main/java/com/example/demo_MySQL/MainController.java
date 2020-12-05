package com.example.demo_MySQL;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo_MySQL.DAO_services.CommandLineService;
import com.example.demo_MySQL.DAO_services.CommandService;
import com.example.demo_MySQL.DAO_services.UserInformationService;
import com.example.demo_MySQL.DAO_services.UserService;
import com.example.demo_MySQL.entities.Command;
import com.example.demo_MySQL.entities.CommandLine;
import com.example.demo_MySQL.entities.User;
import com.example.demo_MySQL.entities.UserInformation;
import com.example.demo_MySQL.repositories.CommandRepository;

@Controller 
@RequestMapping(path="/demo") 
public class MainController {
          
    @Autowired
    private CommandService serviceCMD;
    
    @Autowired
    private CommandLineService serviceCMDLine;
    
    
    @Autowired
    private UserInformationService serviceUserInfo;
    
    @Autowired
    private UserService serviceUser;
    
    @GetMapping(path="/userinfos")
    public @ResponseBody List<UserInformation> getAllUserInfo() {
        return serviceUserInfo.listAll();
    }
    
    @GetMapping(path="/users")
    public @ResponseBody List<User> getAllUser() {
        return serviceUser.listAll();
    }
  
    @GetMapping(path="/commands")
    public @ResponseBody List<Command> getAllCommands() {
        return serviceCMD.listAll();
    }
    
    @GetMapping(path="/commandlines")
    public @ResponseBody List<CommandLine> getAllCommandLines() {
        return serviceCMDLine.listAll();
    }
   
    
   
}