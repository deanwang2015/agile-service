package io.choerodon.agile.api.controller.v1;

import io.choerodon.agile.api.dto.PersonalFilterDTO;
import io.choerodon.agile.app.service.PersonalFilterService;
import io.choerodon.core.exception.CommonException;
import io.choerodon.core.iam.InitRoleCode;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author shinan.chen
 * @since 2019/2/25
 */
@RestController
@RequestMapping(value = "/v1/projects/{project_id}/personal_filter")
public class PersonalFilterController {
    @Autowired
    private PersonalFilterService personalFilterService;

    @Permission(level = ResourceLevel.PROJECT, roles = {InitRoleCode.PROJECT_MEMBER, InitRoleCode.PROJECT_OWNER})
    @ApiOperation("创建我的筛选")
    @PostMapping
    public ResponseEntity<PersonalFilterDTO> create(@ApiParam(value = "项目id", required = true)
                                                    @PathVariable(name = "project_id") Long projectId,
                                                    @ApiParam(value = "personal filter object", required = true)
                                                    @RequestBody PersonalFilterDTO personalFilterDTO) {
        return Optional.ofNullable(personalFilterService.create(projectId, personalFilterDTO))
                .map(result -> new ResponseEntity<>(result, HttpStatus.CREATED))
                .orElseThrow(() -> new CommonException("error.personalFilter.create"));
    }

    @Permission(level = ResourceLevel.PROJECT, roles = {InitRoleCode.PROJECT_MEMBER, InitRoleCode.PROJECT_OWNER})
    @ApiOperation("修改我的筛选")
    @PutMapping(value = "/{filterId}")
    public ResponseEntity<PersonalFilterDTO> update(@ApiParam(value = "项目id", required = true)
                                                    @PathVariable(name = "project_id") Long projectId,
                                                    @ApiParam(value = "filter id", required = true)
                                                    @PathVariable Long filterId,
                                                    @ApiParam(value = "personal filter object", required = true)
                                                    @RequestBody PersonalFilterDTO personalFilterDTO) {
        return Optional.ofNullable(personalFilterService.update(projectId, filterId, personalFilterDTO))
                .map(result -> new ResponseEntity<>(result, HttpStatus.CREATED))
                .orElseThrow(() -> new CommonException("error.personalFilter.create"));
    }

    @Permission(level = ResourceLevel.PROJECT, roles = {InitRoleCode.PROJECT_MEMBER, InitRoleCode.PROJECT_OWNER})
    @ApiOperation("删除我的筛选")
    @DeleteMapping(value = "/{filterId}")
    public ResponseEntity<PersonalFilterDTO> deleteById(@ApiParam(value = "项目id", required = true)
                                                        @PathVariable(name = "project_id") Long projectId,
                                                        @ApiParam(value = "filter id", required = true)
                                                        @PathVariable Long filterId) {
        personalFilterService.deleteById(projectId, filterId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Permission(level = ResourceLevel.PROJECT, roles = {InitRoleCode.PROJECT_MEMBER, InitRoleCode.PROJECT_OWNER})
    @ApiOperation("查询我的筛选列表")
    @GetMapping(value = "/query_all/{userId}")
    public ResponseEntity<List<PersonalFilterDTO>> listByProjectId(@ApiParam(value = "项目id", required = true)
                                                                   @PathVariable(name = "project_id") Long projectId,
                                                                   @ApiParam(value = "用户id", required = true)
                                                                   @PathVariable Long userId,
                                                                   @RequestParam(name = "searchStr") String searchStr) {
        return Optional.ofNullable(personalFilterService.listByProjectId(projectId, userId, searchStr))
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseThrow(() -> new CommonException("error.personalFilter.list"));
    }
}
