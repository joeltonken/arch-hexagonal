package br.com.pos.archhexagonal.adapters.input.web.api;

import br.com.pos.archhexagonal.adapters.input.web.api.request.ContactRequest;
import br.com.pos.archhexagonal.adapters.input.web.api.response.ContactResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/contacts")
public interface ContactApi {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ContactResponse> get(@PathVariable("id") Long id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ContactResponse>> list();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ContactResponse> create(@RequestBody ContactRequest contactRequest);



}
