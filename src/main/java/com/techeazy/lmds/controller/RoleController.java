package com.techeazy.lmds.controller;

import com.techeazy.lmds.entity.Role;
import com.techeazy.lmds.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/roles")
    public class RoleController {
        @Autowired
        private RoleService roleService;

        @GetMapping
        public List<Role> getAllRoles() {
            return roleService.getAllRoles();
        }

        @GetMapping("/{id}")
        public Role getRoleById(@PathVariable Long id) {
            return roleService.getRoleById(id);
        }

        @PostMapping
        public Role createRole(@RequestBody Role role) {
            return roleService.saveRole(role);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
            roleService.deleteRole(id);
            return ResponseEntity.ok().build();
        }
}
