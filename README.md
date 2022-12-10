# Convertor YAML to json

## Task
 
- [Task 1](https://github.com/SemenMartynov/Software-Engineering-2022/blob/main/Task1.md)
_ [Task 2] (https://github.com/SemenMartynov/Software-Engineering-2022/blob/main/Task2.md)
## Descreption project

- small web project that use to convert jaml to json 

## Technology:
- maven
- Java
- Spring boot
- Thymeleaf
## Run project with docker
1. Clone project from github 
```bash
$ git clone https://github.com/Phambanam/ConvertorYamlToJson.git
```
2. CD into project folder
```bash
cd Convertor_yaml_to_json
```
3. Build the image
```bash
docker build -t convert .
```
4. Run the docker image 
```bash
docker run -p 8080:8080 convert
```
## USE 
1. Convert json to Yaml: 
``` http://localhost:8080/json2yaml```
![](/src/main/resources/static/image/1.png)
you can use button copy to take result 
![result](/src/main/resources/static/image/2.png)

2. Convert json to Yaml:
   ``` http://localhost:8080/yaml2json```
   ![](/src/main/resources/static/image/3.png)

   
   You can use the button to switch between the 2 features
   ![result](/src/main/resources/static/image/4.png)
## License
- [MIT](/LICENSE)
## Testing 
- main [![Tests](https://github.com/Phambanam/ConvertorYamlToJson/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/Phambanam/ConvertorYamlToJson/actions/workflows/maven.yml)
- develop [![Tests](https://github.com/Phambanam/ConvertorYamlToJson/actions/workflows/maven.yml/badge.svg?branch=develop)](https://github.com/Phambanam/ConvertorYamlToJson/actions/workflows/maven.yml)