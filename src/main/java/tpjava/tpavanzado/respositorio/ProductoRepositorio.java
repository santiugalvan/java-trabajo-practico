/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpjava.tpavanzado.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import tpjava.tpavanzado.stock.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
    
}
