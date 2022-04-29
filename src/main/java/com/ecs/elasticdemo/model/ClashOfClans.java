package com.ecs.elasticdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "coc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClashOfClans {
    @Id
    private String id;
    private String king;
    private String queen;
    private String arena;
    private String townhall;
    private Integer th_level;
    private Double attack_percent;
    private Long loot;
    private Long spell;
    private boolean isWarToday;
}
