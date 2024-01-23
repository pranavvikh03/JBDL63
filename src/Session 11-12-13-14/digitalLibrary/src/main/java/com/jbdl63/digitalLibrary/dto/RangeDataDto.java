package com.jbdl63.digitalLibrary.dto;

import com.jbdl63.digitalLibrary.Model.Author;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RangeDataDto {
    private Integer dataSize;
    private List<Author> data;
}
