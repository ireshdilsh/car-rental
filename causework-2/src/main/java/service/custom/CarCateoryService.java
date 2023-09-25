package service.custom;

import dto.CarCategoryDto;
import service.SuperService;

public interface CarCateoryService<C> extends SuperService {
    void saveCategory(CarCategoryDto carCategoryDto);

    void updateCarCategory(CarCategoryDto carCategoryDto);

    CarCategoryDto search(String cacategoryId);

    void deleteCarCategory(CarCategoryDto dto);
}
