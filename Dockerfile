FROM node:19-alpine

ENV NODE_ENV=prod
ENV HOST_ORIGIN = "https://mythicaltable.top"

WORKDIR /app

COPY package.json ./

RUN npm install

COPY . .

EXPOSE 3000

CMD ["npm", "start"]
