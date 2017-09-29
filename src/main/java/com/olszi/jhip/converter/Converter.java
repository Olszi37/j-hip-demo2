package com.olszi.jhip.converter;

public interface Converter<Entity, DTO> {

    public DTO convertToDto(Entity entity);

    public Entity convertToEntity(DTO dto);
}
