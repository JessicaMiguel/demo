package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CuentaCorriente")

public class CuentaCorriente {

    @Id
    @SequenceGenerator(
            name = "cuenta_corriente_sequence",
            sequenceName = "cuenta_corriente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cuenta_corriente_sequence"
    )
    private Long ID_cuenta_corriente;

    @Column(name="fecha_recibo")
    private Date fecha_recibo;

    @Column(name="fecha_vto")
    private Date fecha_vto;

    @Column(name="fecha_pago")
    private Date fecha_pago;

    @Column(name="sucursal")
    private Long sucursal;

    @Column(name="tipo_comprobante")
    private String tipo_comprobante;

   // @Column(name="cuota")
    //private Long cuota; no se para que es

   // @Column(name="concepto") es en concepto de remito o factura
   // private Long concepto;

    @Column(name="razon_social")
    private String razon_social;

    @Column(name="Id_cliente")
    private Long Id_cliente;

    @Column(name="telefono_cliente")
    private String telefono_cliente;

    @Column(name="direccion_cliente")
    private String direccion_cliente;

    @Column(name="debe")
    private double debe;

    @Column(name="haber")
    private double haber;

    @Column(name="saldo_inicial")
    private double saldo_inicial;

    @Column(name="saldo_cliente")
    private double saldo_cliente;
    /*
    Preguntar si hacer dos tablas, sino filtrar por Id_cliente (generado por la empresa de embalajes)
    para obtener todos lo items de la cuenta corriente

     */
}
