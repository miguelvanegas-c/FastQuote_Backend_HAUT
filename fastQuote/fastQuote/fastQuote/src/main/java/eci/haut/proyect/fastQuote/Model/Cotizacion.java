package eci.haut.proyect.fastQuote.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "Cotizacion") // Debe coincidir exacto con Mongo Atlas
public class Cotizacion {

    @Id
    private String id;

    private String referenceName; // Nombre del zapato (ej: "Nike Air Max")
    private String category;      // Categoría (ej: "Deportivo")
    private String clientEmail;   // Email del cliente
    private Double quotedPrice;   // Precio cotizado
    private LocalDateTime queryDate; // Fecha de la consulta

    public Cotizacion() {}

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getReferenceName() { return referenceName; }
    public void setReferenceName(String referenceName) { this.referenceName = referenceName; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getClientEmail() { return clientEmail; }
    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }
    public Double getQuotedPrice() { return quotedPrice; }
    public void setQuotedPrice(Double quotedPrice) { this.quotedPrice = quotedPrice; }
    public LocalDateTime getQueryDate() { return queryDate; }
    public void setQueryDate(LocalDateTime queryDate) { this.queryDate = queryDate; }
}