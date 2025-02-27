| **Operacao**                                    | **Metodo HTTP** | **URL**                                        | **Corpo JSON da Requisicao**                  |
|-------------------------------------------------|-----------------|------------------------------------------------|-----------------------------------------------|
| **1. Criar uma Etiqueta**                       | `POST`          | `/etiquetas`                                   | ```json { "nome": "Nova Etiqueta" } ```       |
| **2. Obter todas as Etiquetas**                 | `GET`           | `/etiquetas`                                   | N/A                                           |
| **3. Obter Etiqueta por ID**                    | `GET`           | `/etiquetas/{id}`                              | N/A                                           |
| **4. Atualizar uma Etiqueta**                   | `PUT`           | `/etiquetas/{id}`                              | ```json { "nome": "Etiqueta Atualizada" } ``` |
| **5. Atualizar parcialmente Etiqueta**          | `PATCH`         | `/etiquetas/{id}`                              | ```json { "nome": "Etiqueta Parcial" } ```    |
| **6. Deletar uma Etiqueta**                     | `DELETE`        | `/etiquetas/{id}`                              | N/A                                           |
| **7. Criar uma Palavra**                        | `POST`          | `/palavras`                                    | ```json { "termo": "Nova Palavra" } ```       |
| **8. Obter todas as Palavras**                  | `GET`           | `/palavras`                                    | N/A                                           |
| **9. Obter Palavra por ID**                     | `GET`           | `/palavras/{id}`                               | N/A                                           |
| **10. Atualizar uma Palavra**                   | `PUT`           | `/palavras/{id}`                               | ```json { "termo": "Palavra Atualizada" } ``` |
| **11. Atualizar parcialmente Palavra**          | `PATCH`         | `/palavras/{id}`                               | ```json { "termo": "Palavra Parcial" } ```    |
| **12. Deletar uma Palavra**                     | `DELETE`        | `/palavras/{id}`                               | N/A                                           |
| **13. Associar uma Palavra a uma Etiqueta**     | `POST`          | `/etiquetas/{etiquetaId}/palavras/{palavraId}` | N/A                                           |
| **14. Desassociar uma Palavra de uma Etiqueta** | `DELETE`        | `/etiquetas/{etiquetaId}/palavras/{palavraId}` | N/A                                           |
| **15. Obter todas as Palavras de uma Etiqueta** | `GET`           | `/etiquetas/{etiquetaId}/palavras`             | N/A                                           |
| **16. Associar uma Etiqueta a uma Palavra**     | `POST`          | `/palavras/{palavraId}/etiquetas/{etiquetaId}` | N/A                                           |
| **17. Desassociar uma Etiqueta de uma Palavra** | `DELETE`        | `/palavras/{palavraId}/etiquetas/{etiquetaId}` | N/A                                           |
| **18. Obter todas as Etiquetas de uma Palavra** | `GET`           | `/palavras/{palavraId}/etiquetas`              | N/A                                           |