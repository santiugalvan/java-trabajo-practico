package tpjava.tpavanzado.stock;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idMovimiento;
    String descripcion;

    String fecha;

    Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    Producto producto;


    @Column(nullable = false)
    private String tipoMovimiento;

    public void setTipoMovimiento(String tipoMovimiento) {
        if (tipoMovimiento.matches("^(credito|debito)$")) {
            this.tipoMovimiento = tipoMovimiento;
        } else {
            throw new IllegalArgumentException("El tipo de movimiento debe ser credito o debito");
        }
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }
}