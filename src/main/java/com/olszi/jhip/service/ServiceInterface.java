package com.olszi.jhip.service;

import java.io.Serializable;
import java.util.List;

public interface ServiceInterface<ENTITY, ID extends Serializable> {

    List<ENTITY> findAll();
}
