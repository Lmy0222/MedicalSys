package bak.service;

import bak.domain.Offdoc;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.R;

public interface OffdocService extends IService<Offdoc> {

    R<Integer> addOffdoc(Offdoc offdoc);


}
