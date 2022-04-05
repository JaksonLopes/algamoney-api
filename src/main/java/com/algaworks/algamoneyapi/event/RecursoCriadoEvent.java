package com.algaworks.algamoneyapi.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

@Getter
@Setter
public class RecursoCriadoEvent extends ApplicationEvent {

    private static final long serialVersionUID= 1L ;

    private HttpServletResponse response;
    private Long id;

    public RecursoCriadoEvent(Object source, HttpServletResponse response , Long id) {
        super(source);
        this.response = response;
        this.id = id;
    }
}
