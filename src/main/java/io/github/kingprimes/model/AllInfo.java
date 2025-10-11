package io.github.kingprimes.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AllInfo {
    /**
     * CPU 信息
     */
    CpuInfo cpuInfo;
    /**
     * JVM 信息
     */
    JvmInfo jvmInfo;
    /**
     * 系统信息
     */
    SystemInfo systemInfo;
    /**
     * 盘符信息
     */
    SysFileInfos sysFileInfos;
}
