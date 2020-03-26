import * as API from "./APIService";

export const postHospital = async (id: string, dto: any) => {
  const data = await API.APIPOST(`api/hospitals/${id}`, dto);
  return data;
};

export const getAllHospitals = async () => {
  const data = await API.APIGET("/api/hospitals");
  return data;
};

export const getHospitalCapacity = async (hospitalId: string) => {
  const data = await API.APIGET(`/api/hospitals/${hospitalId}/capacity`);
  return data;
};

export const getHospital = async (hospitalId: string) => {
  const data = await API.APIGET(`/api/hospitals/${hospitalId}`);
  return data;
};

export const patchHospital = async (id: string, dto: any) => {
  const data = await API.APIPATCH(`/api/hospitals/${id}`, dto);
  return data;
};

export const deleteHospital = async (id: string, dto?: any) => {
  const data = await API.APIDELETE(`/api/hospitals/${id}`, dto);
  return data;
};
