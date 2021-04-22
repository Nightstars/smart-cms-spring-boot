package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.apps.CreateOrUpdateAppsDTO;
import io.github.talelin.latticy.model.AppsDO;
import io.github.talelin.latticy.service.AppsService;
import io.github.talelin.latticy.vo.CreatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/apps")
@Validated
public class AppsController {
    @Autowired
    private AppsService appsService;

    @GetMapping("")
    public List<AppsDO> getAll(){
        List<AppsDO> appsDOList=appsService.getAll();
        if(appsDOList.size()<1)
            throw new NotFoundException();
        return appsDOList;
    }

    @PostMapping("")
    public CreatedVO createApp(@RequestBody @Validated CreateOrUpdateAppsDTO validator){
        boolean flag=appsService.createApp(validator);
        return new CreatedVO(10215);
    }
}
