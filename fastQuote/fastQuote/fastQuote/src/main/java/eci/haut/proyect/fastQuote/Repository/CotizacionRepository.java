package eci.haut.proyect.fastQuote.Repository;

import eci.haut.proyect.fastQuote.Model.Cotizacion;
import eci.haut.proyect.fastQuote.Model.DTO.StatDTO;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CotizacionRepository extends MongoRepository<Cotizacion, String> {

    // 1. Top Zapatos más cotizados
    // Agrupa por 'referenceName', cuenta cuántos hay, ordena descendente y toma los 5 primeros
    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$referenceName', 'count': { '$sum': 1 } } }",
            "{ '$sort': { 'count': -1 } }",
            "{ '$limit': 5 }",
            "{ '$project': { 'label': '$_id', 'count': 1, '_id': 0 } }"
    })
    List<StatDTO> findTopRequestedShoes();

    // 2. Estadísticas por Categoría
    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$category', 'count': { '$sum': 1 } } }",
            "{ '$sort': { 'count': -1 } }",
            "{ '$project': { 'label': '$_id', 'count': 1, '_id': 0 } }"
    })
    List<StatDTO> findCategoryStats();
}