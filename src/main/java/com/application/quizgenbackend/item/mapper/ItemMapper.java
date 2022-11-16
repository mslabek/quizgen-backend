package com.application.quizgenbackend.item.mapper;

import com.application.quizgenbackend.item.dto.ItemDto;
import com.application.quizgenbackend.item.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemMapper {

    private final ItemSimpleMapper mapper;

    public ItemDto itemToDto(Item item) {
        return mapper.itemToDto(item);
    }

}
