package lk.ijse.gdse65.AAD_Course_Work.service;

import lk.ijse.gdse65.AAD_Course_Work.Exception.NotFoundException;
import lk.ijse.gdse65.AAD_Course_Work.dto.RefundDTO;
import lk.ijse.gdse65.AAD_Course_Work.entity.RefundEntity;

import java.util.List;

public interface RefundService {
    RefundEntity processRefund(RefundDTO refundDTO) throws NotFoundException;

    ;
}
