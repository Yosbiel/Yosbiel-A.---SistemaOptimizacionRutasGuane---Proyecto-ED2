# Sistema de Optimización de Rutas de Distribución – Guane

## Descripción

Sistema desarrollado en Java para optimizar las rutas de distribución en el municipio Guane, Pinar del Río. Utiliza un **árbol general (N-ario)** implementado desde cero para representar la jerarquía geográfica:

País → Provincia → Municipio → Consejos Populares

Y un **grafo ponderado no dirigido** con **algoritmo de Dijkstra** para calcular rutas mínimas.

## Funcionalidades

- Modelado de la jerarquía territorial mediante árbol general
- Representación de rutas entre Consejos Populares con distancias reales
- Selección de Consejo Popular origen
- Cálculo de distancia mínima y ruta completa usando Dijkstra
- Recorridos BFS y DFS en el grafo

## Tecnologías utilizadas

- Java (JDK 8+)
- NetBeans
- Estructuras de datos personalizadas (árbol general, lista de adyacencia, cola enlazada)

## Cómo ejecutar el proyecto

Clona el repositorio:

git clone https://github.com/Yosbiel/Yosbiel-A.---SistemaOptimizacionRutasGuane---Proyecto-ED2.git
