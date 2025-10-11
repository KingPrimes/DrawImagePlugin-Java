package io.github.kingprimes.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 系统盘符信息
 */
@Data
@Accessors(chain = true)
public class SysFileInfos {

    List<SysFileInfo> sysFileInfos;

    @Data
    @Accessors(chain = true)
    static class SysFileInfo {
        /**
         * 盘符路径
         */
        String dirName;
        /**
         * 盘符类型
         */
        String typeName;
        /**
         * 文件类型
         */
        String fileType;
        /**
         * 总大小
         */
        Long total;
        /**
         * 已使用
         */
        Long used;
    }

}
