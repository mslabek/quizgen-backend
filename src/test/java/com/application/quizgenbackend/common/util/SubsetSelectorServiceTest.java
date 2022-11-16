package com.application.quizgenbackend.common.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(MockitoExtension.class)
class SubsetSelectorServiceTest {

    @InjectMocks
    private SubsetSelectorService selectorService;

    @Test
    void shouldReturnSetOfSpecifiedSize() {
        // Given
        List<Integer> sourceList = List.of(1,2,3,4,5);
        int size = 4;
        // When
        Set<Integer> results = selectorService.selectRandomSubset(sourceList, size);
        // Then
        then(results).hasSize(size);
    }

}
