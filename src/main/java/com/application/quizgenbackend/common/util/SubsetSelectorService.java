package com.application.quizgenbackend.common.util;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class SubsetSelectorService {

    /**
     * Returns a set consisting of randomly selected elements from the source list. The maximum size of this set is
     * limited by the parameter {@code subsetSize}.
     * <p>
     * If there are not enough elements in the source list to create a subset of desired size, calling this method will
     * result in an infinite loop.
     *
     * @param source     the list from which the set will be formed
     * @param subsetSize maximum size of the resulting set
     * @param <T>        the type of elements of the returned set and the parameter source list
     * @return the set of selected elements
     */
    public <T> Set<T> selectRandomSubset(List<T> source, int subsetSize) {
        Set<T> target = new HashSet<>();
        fillUpRandomly(target, source, subsetSize);
        return target;
    }

    /**
     * Returns a set consisting of the required element and randomly selected elements from the source list. The maximum
     * size of this set is limited by the parameter {@code subsetSize}.
     * <p>
     * If there are not enough elements in the source list to create a subset of desired size, calling this method will
     * result in an infinite loop.
     *
     * @param source          the list from which the set will be formed
     * @param requiredElement the element which will necessarily be placed in the resulting set
     * @param subsetSize      maximum size of the resulting set
     * @param <T>             the type of elements of the returned set and the parameter source list
     * @return the set of selected elements
     * @see #selectRandomSubset(List, int)
     */
    public <T> Set<T> selectRandomSubset(List<T> source, T requiredElement, int subsetSize) {
        Set<T> target = new HashSet<>();
        target.add(requiredElement);
        fillUpRandomly(target, source, subsetSize);
        return target;
    }

    private <T> void fillUpRandomly(Set<T> target, List<T> source, int subsetSize) {
        Random random = new Random();
        while (target.size() < subsetSize) {
            int randomIndex = random.nextInt(source.size());
            target.add(source.get(randomIndex));
        }
    }


}
