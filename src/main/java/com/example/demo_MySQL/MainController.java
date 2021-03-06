package com.example.demo_MySQL;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo_MySQL.DAO_services.CommandLineService;
import com.example.demo_MySQL.DAO_services.CommandService;
import com.example.demo_MySQL.DAO_services.PaymentService;
import com.example.demo_MySQL.DAO_services.RoleService;
import com.example.demo_MySQL.DAO_services.UserInformationService;
import com.example.demo_MySQL.DAO_services.UserService;
import com.example.demo_MySQL.entities.Command;
import com.example.demo_MySQL.entities.CommandLine;
import com.example.demo_MySQL.entities.Payment;
import com.example.demo_MySQL.entities.Role;
import com.example.demo_MySQL.entities.User;
import com.example.demo_MySQL.entities.UserInformation;


@Controller 
@RequestMapping(path="/demo") 
public class MainController {
    
    @Autowired
    private PaymentService servicePayment;
    
    @Autowired
    private RoleService serviceRole;
          
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
    
    @GetMapping(path="/roles")
    public @ResponseBody List<Role> getAllRoles() {
        return serviceRole.listAll();
    }
   
    
    @GetMapping(path="/payments")
    public @ResponseBody List<Payment> getAllPayments() {
        return servicePayment.listAll();
    }
    
   
}