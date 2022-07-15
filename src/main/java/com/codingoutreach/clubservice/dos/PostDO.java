package com.codingoutreach.clubservice.dos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PostDO {
    @NotNull
    private UUID postId;

    @NotNull
    private UUID clubId;

    @NotBlank
    private String postTitle;

    @NotNull
    private List<PostTabDO> tabs;
}
