package com.shakedown.persistence.api.impl;

import org.springframework.stereotype.Repository;

import com.shakedown.entitys.Eventos;
import com.shakedown.persistence.api.EventoDAO;

@Repository("eventosDAOImpl")
public class EventosDAOImpl extends GenericDAOImpl<Eventos, Integer> implements EventoDAO {

}
