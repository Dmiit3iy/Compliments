package org.dmiit3iy.controller;

import org.dmiit3iy.dto.ResponseResult;
import org.dmiit3iy.model.Compliment;
import org.dmiit3iy.model.UserDetailsImpl;
import org.dmiit3iy.service.ComplimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compliment")
public class ComplimentController {
    private ComplimentService complimentService;

    @Autowired
    public void setComplimentService(ComplimentService complimentService) {
        this.complimentService = complimentService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseResult<Compliment>> get(@PathVariable int id) {
        try {
            return new ResponseEntity<>(new ResponseResult<>(null,
                    complimentService.getComplimentList().getById(id)), HttpStatus.OK);
        } catch (IndexOutOfBoundsException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<ResponseResult<List<Compliment>>> getAll() {
        return new ResponseEntity<>(new ResponseResult<>(null, complimentService.getComplimentList().getList()), HttpStatus.OK);
    }

    @GetMapping("/next")
    public ResponseEntity<ResponseResult<Compliment>> getRandom(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            long id = ((UserDetailsImpl) authentication.getPrincipal()).getId();
            Compliment compliment = complimentService.getNext(id);
            return new ResponseEntity<>(new ResponseResult<>(null, compliment), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseResult<>("Проблемы с аутентификацией", null), HttpStatus.BAD_REQUEST);
    }

}
