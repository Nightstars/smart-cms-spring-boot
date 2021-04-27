package io.github.talelin.latticy.controller.v1;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupMeta;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.latticy.dto.apps.CreateOrUpdateAppsDTO;
import io.github.talelin.latticy.model.AppsDO;
import io.github.talelin.latticy.service.AppsService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
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

    @GetMapping("/{id}")
    public AppsDO getById(@PathVariable("id") @Positive(message = "{id.positive}") Long id){
        return appsService.getById(id);
    }

    @DeleteMapping("/{id}")
    @GroupMeta(permission = "移除应用",module = "应用管理",mount = true)
    @GroupRequired
    public DeletedVO deleteById(@PathVariable("id") @Positive(message = "{id.positive}") Long id){
        AppsDO appsDO=appsService.getById(id);
        if(appsDO==null)
            throw new NotFoundException();
        boolean rs=appsService.deleteById(appsDO.getId());
        return new DeletedVO(10216);
    }

    @PutMapping("/{id}")
    @GroupMeta(permission = "编辑应用",module = "应用管理",mount = true)
    @GroupRequired
    public UpdatedVO updateById(@PathVariable("id") @Positive(message = "{id.positive}") Long id,@RequestBody CreateOrUpdateAppsDTO createOrUpdateAppsDTO){
        AppsDO appsDO=appsService.getById(id);
        if(appsDO==null)
            throw new NotFoundException();
        boolean rs=appsService.updateById(appsDO,createOrUpdateAppsDTO);
        return new UpdatedVO(10217);
    }
}
