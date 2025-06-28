package com.linlancai.manualtodoapp.dto;

import org.immutables.value.Value.Immutable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Immutable
@JsonSerialize(as = ImmutableGetTodoResponseDto.class)
@JsonDeserialize(as = ImmutableGetTodoResponseDto.class)
public interface GetTodoResponseDto {
    String getId();
    String getTitle();
    String getContent();
    long getCreateAt();
}
