const axios = require('axios')

class API {

  constructor({ url }) {
    this.url = url
    this.endpoints = {}
  }
  /**
   * Create and store a single entity's endpoints
   * @param {A entity Object} entity
   */
  createEntity(entity) {
    this.endpoints[entity.name] = this.createBasicCRUDEndpoints(entity)
  }

  createEntities(arrayOfEntity) {
    arrayOfEntity.forEach(this.createEntity.bind(this))
  }
  /**
   * Create the basic endpoints handlers for CRUD operations
   * @param {A entity Object} entity
   */
  createBasicCRUDEndpoints({ name }) {
    var endpoints = {}

    const resourceURL = `${this.url}/${name}`

    endpoints.getAll = ({ query = {} }, config = {}) => axios.get(resourceURL, Object.assign({ params: { query }, config }))

    endpoints.getOne = ({ id }, config = {}) => axios.get(`${resourceURL}/${id}`, config)

    endpoints.create = (toCreate, config = {}) => axios.post(resourceURL, toCreate, config)

    endpoints.update = (toUpdate, config = {}) => axios.put(`${resourceURL}/${toUpdate.id}`, toUpdate, config)

    endpoints.patch = ({ id }, toPatch, config = {}) => axios.patch(`${resourceURL}/${id}`, toPatch, config)

    endpoints.delete = ({ id }, config = {}) => axios.delete(`${resourceURL}/${id}`, config)

    endpoints.call = ({ name, id }, config = {}) => axios.get(`${resourceURL}/${name}?id=${id}`, config)

    endpoints.post = (name, id, toCreate, config = {}) => axios.post(`${resourceURL}/${name}`, toCreate, config)

    endpoints.save = (toCreate, config = {}) => axios.post(`${resourceURL}/save/`, toCreate, config)

    return endpoints

  }

}

export default API
