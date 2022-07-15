package com.codingoutreach.clubservice.dos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PostTabDO {
    @NotNull
    private UUID tabId;

    @NotNull
    private UUID postId;

    private String header;

    private String textContent;

    private String mediaURL;
}
