package com.smbms.mapper;

import com.smbms.model.SmbmsAddress;
import java.util.List;

public interface SmbmsAddressMapper {
    List<SmbmsAddress> selectAll();
}