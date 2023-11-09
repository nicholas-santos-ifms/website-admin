/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch.v010;

import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author nicho
 * @param <T>
 * @param <DTO>
 * @param <LEANDTO>
 * @param <FORM>
 */
public interface ILeanMapper<T, DTO, LEANDTO, FORM>
        extends ISimpleMapper<T, DTO, FORM> {

    public LEANDTO toLeanDto(T entity);
    
    public T leanDtoToEntity(LEANDTO dto);

    public List<LEANDTO> toLeanDtoList(List<T> items);
    
    public List<T> leandtoToEntityList(List<LEANDTO> items);

    public default Page<LEANDTO> toLeanDtoPage(Page<T> items) {
        return items.map(entity -> toLeanDto(entity));
    }
}
