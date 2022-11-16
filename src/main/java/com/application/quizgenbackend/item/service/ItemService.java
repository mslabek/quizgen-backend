package com.application.quizgenbackend.item.service;

import com.application.quizgenbackend.item.dto.ItemDto;
import com.application.quizgenbackend.item.mapper.ItemMapper;
import com.application.quizgenbackend.item.model.Item;
import com.application.quizgenbackend.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    /**
     * Retrieves all items belonging to the topic.
     *
     * @param topicId the topic related to the searched items
     * @return list of matching items
     */
    @Cacheable("itemsByTopic")
    @Transactional
    public List<ItemDto> getItemsByTopic(Long topicId) {
        return getItem(topicId).stream()
                               .map(itemMapper::itemToDto)
                               .collect(Collectors.toList());
    }

    private List<Item> getItem(Long topicId) {
        return itemRepository.findAllByTopicId(topicId);
    }

    /**
     * Returns the number of items belonging to the topic.
     *
     * @param topicId the topic related to the searched items
     * @return the number of matching items
     */
    @Cacheable("itemsCount")
    public int countItemsByTopic(Long topicId) {
        return itemRepository.countByTopic(topicId);
    }

}
