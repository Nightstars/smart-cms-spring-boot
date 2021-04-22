package io.github.talelin.latticy.dto.apps;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CreateOrUpdateAppsDTO {
    @NotEmpty(message = "{apps.name.no-empty}")
    @Size(max = 50,message = "{apps.name.max-size}")
    private String name;

    @NotEmpty(message = "{apps.url.no-empty}")
    @Size(max = 255,message = "{apps.url.max-size}")
    private String url;

    @NotEmpty(message = "{apps.icon.no-empty}")
    @Size(max = 512,message = "{apps.icon.max-size}")
    private String icon;

    @NotEmpty(message = "{apps.summary.no-empty}")
    @Size(max = 1000,message = "{apps.summary.max-size}")
    private String summary;
}
