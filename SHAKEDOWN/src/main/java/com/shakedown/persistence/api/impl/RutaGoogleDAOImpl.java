package com.shakedown.persistence.api.impl;

import org.springframework.stereotype.Repository;

import com.shakedown.entitys.RutaGoogle;
import com.shakedown.persistence.api.RutaGoogleDAO;

@Repository("rutaGoogleDAO")
public class RutaGoogleDAOImpl extends GenericDAOImpl<RutaGoogle, Integer> implements RutaGoogleDAO {

}
