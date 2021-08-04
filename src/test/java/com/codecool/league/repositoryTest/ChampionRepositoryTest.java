package com.codecool.league.repositoryTest;

import com.codecool.league.dao.repository.ChampionsRepository;
import com.codecool.league.model.champions.ChampionModel;
import com.codecool.league.model.champions.Info;
import com.codecool.league.model.champions.Stats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class ChampionRepositoryTest {

    @Autowired
    private ChampionsRepository championsRepository;

    private final List<String> keys = Arrays.asList("1", "2", "3");

    private ChampionModel champion;

    @BeforeEach
    public void setup() {
        champion = ChampionModel.builder()
                .name("Aatrox")
                .id("aatrox")
                .title("fighter")
                .blurb("He is a great fighter from Hungary")
                .info(new Info(2, 2, 2, 2))
                .free(true)
                .key("2")
                .partype("assassin")
                .stats(new Stats())
                .version("11")
                .tags(Arrays.asList("Fighter", "Tank"))
                .build();
    }

    @Test
    void findAllWithExistingChampion() {
        championsRepository.save(champion);

        assertThat(championsRepository.findAll())
                .hasSize(1)
                .allMatch(championFromRepository -> championFromRepository.getName().equals("Aatrox"));
    }

    @Test
    void findAllByTagsWithExistingTag() {
        championsRepository.save(champion);

        assertThat(championsRepository.findAllByTags("Tank"))
                .hasSize(1)
                .anyMatch(championFromRepository -> championFromRepository.getName().equals("Aatrox"));
    }

    @Test
    void findAllByTagsWithNonExistingTag() {
        championsRepository.save(champion);

        assertThat(championsRepository.findAllByTags("Support"))
                .hasSize(0);
    }

    @Test
    void findAllByKeyInWithExistingKey() {
        championsRepository.save(champion);

        assertThat(championsRepository.findAllByKeyIn(keys))
                .hasSize(1)
                .anyMatch(championFromRepository -> championFromRepository.getId().equals("aatrox"));
    }

    @Test
    void findAllByKeyInWithNonExistingKeyInRepositoryHasNoElements() {
        assertThat(championsRepository.findAllByKeyIn(keys))
                .hasSize(0);
    }
}